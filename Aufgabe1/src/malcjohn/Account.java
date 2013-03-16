package malcjohn;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Account {
	public static int accountNumber;
	public static double overdraft;
	public static double bankDeposit;
	public static int pin;

	// Constructor for this class
	public Account(int accountNumberX, double bankDepostiX) {
		Account.accountNumber = accountNumberX;
		Account.bankDeposit = bankDepostiX;
	}

	public Account() {

	}

	// Methods for AccountNumber, BankDeposit, Overdraft and
	// Pin Always both, set and get methods.

	/**
	 * Speicherung der Kontonummer
	 * 
	 * @param value
	 */
	public void setAccountNumber(int value) {
		Account.accountNumber = value;
	}

	public int getAccountNumber() {
		return Account.accountNumber;
	}

	/**
	 * Dispokredit des Kontos
	 * 
	 * @param value2
	 */
	public void setOverdraft(double value2) {
		Account.overdraft = value2;
	}

	public double getOverdraft() {
		return Account.overdraft;
	}

	/**
	 * die Hohe des Kontoguthabens
	 * 
	 * @param value3
	 */
	public void setBankDeposit(double value3) {
		Account.bankDeposit = value3;
	}

	public double getBankDeposit() {
		return Account.bankDeposit;
	}

	/**
	 * Set pin for Account class
	 * 
	 * @param value4
	 */
	public void setPin(int value4) {
		Account.pin = value4;
	}

	public int getPin() {
		return this.pin;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
