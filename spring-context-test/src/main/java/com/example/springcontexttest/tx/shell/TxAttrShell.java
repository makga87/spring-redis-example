package com.example.springcontexttest.tx.shell;

import com.example.springcontexttest.tx.srv.TxAttrSrv;
import com.example.springcontexttest.tx.srv.TxSrv;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * TransactionInterceptor, TransactionManager, PlatformTransactionManager
 */
@ShellComponent
public class TxAttrShell {
    private final TxAttrSrv txAttrSrv;

    public TxAttrShell(TxAttrSrv txAttrSrv) {
        this.txAttrSrv = txAttrSrv;
    }


}
