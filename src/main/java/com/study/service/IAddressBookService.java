package com.study.service;

import com.study.domain.AddressBook;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 地址管理 服务类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Transactional
public interface IAddressBookService extends IService<AddressBook> {

}
