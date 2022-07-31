package com.study.service.impl;

import com.study.domain.AddressBook;
import com.study.dao.AddressBookDao;
import com.study.service.IAddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地址管理 服务实现类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookDao, AddressBook> implements IAddressBookService {

}
