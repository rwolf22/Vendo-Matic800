package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed MOney";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,PURCHASE_MENU_OPTION_SELECT_PRODUCT,PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private static final String FEED_MONEY_OPTION_1 = "$1";
	private static final String FEED_MONEY_OPTION_2 = "$2";
	private static final String FEED_MONEY_OPTION_5 = "$5";
	private static final String FEED_MONEY_OPTION_10 = "$10";
	private static final String [] FEED_MONEY_OPTIONS = {FEED_MONEY_OPTION_1,FEED_MONEY_OPTION_2,FEED_MONEY_OPTION_5,FEED_MONEY_OPTION_10};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		double currentMoneyProvided = 0;
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				Inventory.displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				while (true) {
					System.out.println ("Current Money Provided: " + currentMoneyProvided);
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						String feedMoneyChoice = (String) menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
						if (feedMoneyChoice.equals (FEED_MONEY_OPTION_1)) {
							currentMoneyProvided += 1.0;
						}
						else if (feedMoneyChoice.equals (FEED_MONEY_OPTION_2)) {
							currentMoneyProvided += 2.0;
						}
						else if (feedMoneyChoice.equals (FEED_MONEY_OPTION_5)) {
							currentMoneyProvided += 5.0;
						}
						else if (feedMoneyChoice.equals (FEED_MONEY_OPTION_10)) {
							currentMoneyProvided += 10.0;
						}
					}
					else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						Product productChoice = (Product) menu.getChoiceFromOptions(Inventory.INVENTORY_ARRAY);
						if (productChoice.getStock()<1){
							System.out.println ("Product Is Out Of Stock");
						}
						else if (currentMoneyProvided < productChoice.getPrice()){
							System.out.println ("Not Enough Money Provided");
						}
						else {
							System.out.println (productChoice.despensingMessage());
							productChoice.sellProduct();
							currentMoneyProvided -= productChoice.getPrice();
						}
					}
					else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {

					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
