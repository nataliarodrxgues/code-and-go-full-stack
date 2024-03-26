package com.agencia;

import java.util.Scanner;

import com.agencia.menus.ClientesIO;
import com.agencia.menus.ContatosIO;
import com.agencia.menus.DestinosIO;
import com.agencia.menus.MenuIO;
import com.agencia.menus.PedidosIO;
import com.agencia.menus.PromocoesIO;
import com.agencia.utils.Colors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int option = 0;

		do {

			option = MenuIO.menu(scanner);

			switch (option) {
			case 1:
				ClientesIO.SubMenuClientes(scanner);
				break;
			case 2:
				PedidosIO.SubMenuPedidos(scanner);
				break;
			case 3:
				DestinosIO.SubMenuDestinos(scanner);
				break;
			case 4:
				PromocoesIO.SubMenuPromocoes(scanner);
				break;
			case 5:
				ContatosIO.SubMenuContatos(scanner);
				break;
			default:
				System.out.println(Colors.RED.get() + "Digite uma opcao valida!" + Colors.RED.get());

			}

		} while (option != 6);
		scanner.close();

	}

}
	
	