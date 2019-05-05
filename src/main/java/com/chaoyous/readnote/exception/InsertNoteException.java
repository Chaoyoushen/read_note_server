package com.chaoyous.readnote.exception;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/4
 */
public class InsertNoteException extends CustomException {
    public InsertNoteException() {
        super(1005, "something wrong with mysql while insert note");
    }
}
