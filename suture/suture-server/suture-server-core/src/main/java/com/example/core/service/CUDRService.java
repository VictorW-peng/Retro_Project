package com.example.core.service;

import java.util.List;

/**
 * @author: William.Peng
 * @date: 2022/10/18 17:13
 * @description:
 */
public interface CUDRService<T> {

    /**
     * 保存操作
     * @param record
     * @return
     */
    int save(T record);

    /**
     * 删除操作
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 批量删除操作
     * @param records
     */
    int delete(List<T> records);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    T findById(Long id);

}
