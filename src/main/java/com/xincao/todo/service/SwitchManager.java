package com.xincao.todo.service;

import com.xincao.todo.mapper.SwitchInfoMapper;
import com.xincao.todo.model.SwitchInfo;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 开关支持，等级控制和道具开启
 */
@Service
public class SwitchManager {

    private final Map<String, BitSet> switchMap = new HashMap<String, BitSet>();
    @Autowired
    private SwitchInfoMapper switchInfoMapper;

    public boolean switchM(String account, SwitchFlag switchFlag) {
        if (!switchMap.containsKey(account)) {
            System.out.println("heroId = {" + account + "} switch do not init");
            return false;
        }
        return switchMap.get(account).get(switchFlag.getNo());
    }

    /**
     * 开启开关
     * 
     * @param account
     * @param switchFlag
     * @param level
     * @return 
     */
    public boolean updateSwitch(String account, SwitchFlag switchFlag, int level) {
        if (switchMap.containsKey(account)) {
            BitSet bitSet = switchMap.get(account);
            if (switchFlag.getLevel() != -1 && switchFlag.isFree()) { // 和等级有关，且不需要消耗物品
                if (level >= switchFlag.getLevel()) {
                    bitSet.set(switchFlag.getNo(), true);
                }
            } else if (switchFlag.getLevel() != -1 && !switchFlag.isFree()) { // 和等级有关，且需要消耗物品
                 if (level >= switchFlag.getLevel()) {
                    // 减少道具
                    bitSet.set(switchFlag.getNo(), true);
                }
            } else if (switchFlag.getLevel() == -1 && switchFlag.isFree()) { // 和等级无关，且不需要消耗物品
                bitSet.set(switchFlag.getNo(), true);
            } else if (switchFlag.getLevel() == -1 && !switchFlag.isFree()) { // 和等级无关，且需要消耗物品
                // 减少道具
                bitSet.set(switchFlag.getNo(), true);
            }
        } else {
            
        }
        return false;
    }

    public static enum SwitchFlag {

        TEST(1, 10, false), // 测试
        HOLY_SPIRIT(2, 28, true); // 圣灵

        public static final List<SwitchFlag> switchFlags = Arrays.asList(values());

        private final int no; // 编号
        private final int level; // 等级， -1 表示与等级无关
        private final boolean free; // 是否需要消耗其他道具

        private SwitchFlag(int no, int level, boolean free) {
            this.no = no;
            this.level = level;
            this.free = free;
        }

        public int getNo() {
            return this.no;
        }

        public int getLevel() {
            return this.level;
        }

        public boolean isFree() {
            return this.free;
        }
    }

    public void saveToDB(String account) {
        if (switchMap.containsKey(account)) {
            BitSet bitSet = switchMap.get(account);
            JSONObject json = new JSONObject();
            for (SwitchFlag s : SwitchFlag.switchFlags) {
                int v = bitSet.get(s.getNo()) ? 1 : 0;
                try {
                    json.put(String.valueOf(s.getNo()), v);
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                }
            }
            SwitchInfo switchInfo = new SwitchInfo();
            switchInfo.setAccount(account);
            switchInfo.setSwitchInfo(json.toString());
            switchInfoMapper.updateByPrimaryKey(switchInfo);
        } else {
            System.out.println("heroId = {" + account + "} switch do not init");
        }
    }

    public void loadFromDB(String account) {
        if (!switchMap.containsKey(account)) {
            try {
                SwitchInfo switchInfo = new SwitchInfo();
                switchInfo.setAccount(account);
                String str = switchInfoMapper.selectByPrimaryKey(switchInfo).getSwitchInfo();
                JSONObject json = JSONObject.fromObject(str);
                Iterator<String> iter = json.keys();
                while (iter.hasNext()) {
                    String k = iter.next();
                    int v = (Integer) json.get(k);
                    BitSet bitSet = new BitSet();
                    bitSet.set(Integer.valueOf(k), v == 1);
                    switchMap.put(account, bitSet);
                }
            } catch (JSONException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("heroId = {" + account + "} switch has been initialized");
        }
    }

}