package com.todo.mapper;

import com.todo.model.SwitchInfo;
import com.todo.model.SwitchInfoKey;

public interface SwitchInfoMapper {

    public int deleteByPrimaryKey(SwitchInfoKey key);

    public int insert(SwitchInfo record);

    public int insertSelective(SwitchInfo record);

    public SwitchInfo selectByPrimaryKey(SwitchInfoKey key);

    public int updateByPrimaryKeySelective(SwitchInfo record);

    public int updateByPrimaryKey(SwitchInfo record);
}