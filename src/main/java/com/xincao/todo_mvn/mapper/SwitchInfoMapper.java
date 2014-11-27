package com.xincao.todo_mvn.mapper;

import com.xincao.todo_mvn.model.SwitchInfoKey;
import com.xincao.todo_mvn.model.SwitchInfo;

public interface SwitchInfoMapper {

    public int deleteByPrimaryKey(SwitchInfoKey key);

    public int insert(SwitchInfo record);

    public int insertSelective(SwitchInfo record);

    public SwitchInfo selectByPrimaryKey(SwitchInfoKey key);

    public int updateByPrimaryKeySelective(SwitchInfo record);

    public int updateByPrimaryKey(SwitchInfo record);
}