package com.example.springcontexttest.tx.shell;

import com.example.springcontexttest.tx.srv.TxSrv;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * TransactionInterceptor, TransactionManager, PlatformTransactionManager
 */
@ShellComponent
public class TxShell {
    private final TxSrv txSrv;

    public TxShell(TxSrv txSrv) {
        this.txSrv = txSrv;
    }

    @ShellMethod(value = "향상된 for문에서 예외를 try-catch로 잡는 경우, 예외 발생 케이스를 제외한 쿼리들은 그대로 진행한다", key = "tx-case1")
    public void txTest1(){
        txSrv.insert10TimesFor_tryCatch();
    }

    @ShellMethod(value = "향상된 for문에서 Exception을 throw 하는 경우, 예외 발생 이후 로직은 진행하지 않는다", key = "tx-case2")
    public void txTest2() throws Exception {
        txSrv.insert10TimesFor_throwException();
    }

    @ShellMethod(value = "향상된 for문에서 Exception을 throw 하고, @Transactional 선언한 경우, 롤백이 된다", key = "tx-case3")
    public void txTest3() throws Exception {
        txSrv.insert10TimesFor_throwExceptionTransaction();
    }
    @ShellMethod(value = "향상된 for문에서 Exception을 throw 하고, @Transactional 선언하고, rollbackFor에 아무것도 입력하지 않으면, 롤백이 되지 않는다", key = "tx-case4")
    public void txTest4() throws Exception {
        txSrv.insert10TimesFor_throwExceptionTransaction_withoutRollbackFor();
    }

    @ShellMethod(value = "향상된 for문에서 RuntimeException을 throw 하고, 선언하지 않으면, 롤백이 되지 않는다", key = "tx-case5")
    public void txTest5() throws Exception {
        txSrv.insert10TimesFor_throwRuntimeException();
    }

    @ShellMethod(value = "향상된 for문에서 RuntimeException을 throw 하고, @Transactional 선언하면, 롤백이 된다", key = "tx-case6")
    public void txTest6() throws Exception {
        txSrv.insert10TimesFor_throwRuntimeExceptionTransaction();
    }

    @ShellMethod(value = "stream에서 예외를 try-catch로 잡는 경우, 예외 발생 케이스를 제외한 쿼리들은 그대로 진행한다", key = "tx-case7")
    public void txTest7(){
        txSrv.insert10TimesStream();
    }

    @ShellMethod(value = "stream에서 예외를 Exception throw 하고, @Transactional 선언한 경우, 롤백이 되지 않는다", key = "tx-case8")
    public void txTest8(){
        txSrv.insert10TimesStream_throwExceptionTransaction();
    }

    @ShellMethod(value = "stream에서 예외를 RuntimeException throw 하고, @Transactional 선언하지 않은 경우, 롤백이 되지 않는다", key = "tx-case9")
    public void txTest9(){
        txSrv.insert10TimesStream_throwRuntimeException();
    }

    @ShellMethod(value = "stream에서 예외를 RuntimeException throw 하고, @Transactional 선언한 경우, 롤백이 되지 않는다", key = "tx-case10")
    public void txTest10(){
        txSrv.insert10TimesStream_throwRuntimeExceptionTransaction();
    }


    @ShellMethod(value = "with sleep, @Transactional 없음", key = "tx-case11")
    public void txTeset11() throws InterruptedException {
        txSrv.transactional_with_sleep_db_down_1();
    }
    @ShellMethod(value = "with sleep, @Transactional 있음", key = "tx-case12")
    public void txTeset12() throws InterruptedException {
        txSrv.transactional_with_sleep_db_down_2();
    }
    @ShellMethod(value = "with sleep, @Transactional 있음", key = "tx-case13")
    public void txTeset13() {
        txSrv.transactional_with_sleep_db_down_3();
    }

    @ShellMethod(value = "private 메서드들과 @Transactional", key = "tx-case14")
    public void txTest14() throws Exception {
        txSrv.insert3Times_private();
    }

    @ShellMethod(value = "tx-case13에서 @Transactional만 없는 경우", key = "tx-case15")
    public void txTest15() throws Exception {
        txSrv.transactional_with_sleep_db_down_4();
    }

    /**
     * 이하, 발표용 샘플
     */
    @ShellMethod(value = "정상적인 동작을 확인해본다. (for, throw, @Transactional)", key = "tx-prt1")
    public void txPractice1() throws Exception {
        txTest3();
    }

    @ShellMethod(value = "잘못된 적용을 확인해본다. (for, try-catch, @Transactional)", key = "tx-prt2")
    public void txPractice2() throws Exception {
        txTest1();
    }

    @ShellMethod(value = "stream에서 동작을 확인해본다. (stream, @Transactional)", key = "tx-prt3")
    public void txPractice3() throws Exception {
        txTest8();
    }

    @ShellMethod(value = "stream에서도 롤백이 되는 경우를 확인해본다. (stream, @Transactional, db 끊김)", key = "tx-prt4")
    public void txPractice4() throws Exception {
        txTeset13();
    }

    @ShellMethod(value = "tx-prt4번에서 @Transactional을 뺀 경우를 확인해본다. (stream, db 끊김)", key = "tx-prt5")
    public void txPractice5() throws Exception {
        txTest15();
    }

    @ShellMethod(value = "디비 초기화", key = "tx-clear")
    public void txClear(){
        txSrv.delete();
    }

}
