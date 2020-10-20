package OriginalCode.Interface;

import OriginalCode.Exception.*;
public interface Credit {
    void minusCredit(int number) throws InvalidInputException, CreditNotEnoughException;
}
