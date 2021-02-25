package org.javaboy.service;/**
 * @author leo
 * @date 2021/2/25
 * @apiNote
 */

import org.javaboy.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName AccountService
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/25 14:55
 * @Version 1.0
 **/
@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    @Transactional(rollbackFor = Exception.class)
    public void updateMoney() {
        accountDao.addMoney("zhangsan", 200);
        int i = 1 / 0;
        accountDao.minMoney("lisi", 200);
    }
}
