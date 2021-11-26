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


    @ShellMethod(value = "실습 1, @Transactional 없음", key = "tx-prt1")
    public void txPractice1() throws InterruptedException {
        txSrv.transactional_practice_1();
    }
    @ShellMethod(value = "실습 2, @Transactional 있음", key = "tx-prt2")
    public void txPractice2() throws InterruptedException {
        txSrv.transactional_practice_2();
    }
    @ShellMethod(value = "실습 3, @Transactional 있음", key = "tx-prt3")
    public void txPractice3() {
        txSrv.transactional_practice_3();
    }

    @ShellMethod(value = "private 메서드들과 @Transactional", key = "tx-case11")
    public void txTest11() throws Exception {
        txSrv.insert3Times_private();
    }

    @ShellMethod(value = "public 메서드들과 @Transactional", key = "tx-case12")
    public void txTest12() throws Exception {
        txSrv.insert3Times_public();
    }

    @ShellMethod(value = "디비 초기화", key = "tx-clear")
    public void txClear(){
        txSrv.delete();
    }

}
