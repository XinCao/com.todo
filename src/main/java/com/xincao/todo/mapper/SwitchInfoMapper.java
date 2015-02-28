package com.xincao.todo.mapper;

import com.xincao.todo.model.SwitchInfoKey;
import com.xincao.todo.model.SwitchInfo;

public interface SwitchInfoMapper {

    public int deleteByPrimaryKey(SwitchInfoKey key);

    public int insert(SwitchInfo record);

    public int insertSelective(SwitchInfo record);

    public SwitchInfo selectByPrimaryKey(SwitchInfoKey key);

    public int updateByPrimaryKeySelective(SwitchInfo record);

    public int updateByPrimaryKey(SwitchInfo record);
}