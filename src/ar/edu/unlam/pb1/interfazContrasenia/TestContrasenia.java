package ar.edu.unlam.pb1.interfazContrasenia;

import java.util.Scanner;

public class TestContrasenia {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// Debe tener una longitud de 8 caracteres
		// debe tener al menos 1 mayus, 1 numero, 1 miniscula y 1 caracter especial
		String contrasenia = "";
		boolean contraseniaValida = false;

		mostrarMensaje("Ingrese una contraseña");
		contrasenia = teclado.next();
		contraseniaValida = validarContrasenia(contrasenia);
		notificarSiLaContraseniaEsValida(contraseniaValida);
	}

	private static void notificarSiLaContraseniaEsValida(boolean contraseniaValida) {
		if (contraseniaValida) {
			mostrarMensaje("CONTRASEÑA VALIDA");
		} else {
			mostrarMensaje("CONTRASEÑA NO VALIDA");
		}

	}

	private static boolean validarContrasenia(String contrasenia) {
		boolean contraseniaValida = false;
		boolean longitudCorrecta = false;
		boolean tieneUnaMayuscula = false;
		boolean tieneUnaMinuscula = false;
		boolean tieneUnNumero = false;
		boolean tieneUnCaracterEspecial = false;

		longitudCorrecta = verficarLongitudContrasenia(contrasenia);
		tieneUnaMayuscula = verificarMayuscula(contrasenia);
		tieneUnaMinuscula = verificarMinuscula(contrasenia);
		tieneUnNumero = verificarNumero(contrasenia);
		tieneUnCaracterEspecial = verificarCaracterEspecial(contrasenia);

		if (longitudCorrecta && tieneUnaMayuscula && tieneUnaMinuscula && tieneUnNumero && tieneUnCaracterEspecial) {
			contraseniaValida = true;
		}
		return contraseniaValida;
	}

	private static boolean verificarCaracterEspecial(String contrasenia) {
		Boolean tieneCaracterEspecial = false;
		Character caracterDeContrasenia;

		for (int i = 0; i < contrasenia.length(); i++) {
			caracterDeContrasenia = contrasenia.charAt(i);
			if (!(Character.isDigit(caracterDeContrasenia)) && !(Character.isUpperCase(caracterDeContrasenia))
					&& !(Character.isLowerCase(caracterDeContrasenia))) {
				tieneCaracterEspecial = true;
			}
		}
		return tieneCaracterEspecial;
	}

	private static boolean verificarNumero(String contrasenia) {
		boolean tieneUnNumero = false;
		Character caracterDeContrasenia;

		for (int i = 0; i < contrasenia.length(); i++) {
			caracterDeContrasenia = contrasenia.charAt(i);
			if (Character.isDigit(caracterDeContrasenia)) {
				tieneUnNumero = true;
			}
		}
		return tieneUnNumero;
	}

	private static boolean verificarMinuscula(String contrasenia) {
		boolean tieneUnaMinuscula = false;
		Character caracterDeContrasenia;
		for (int i = 0; i < contrasenia.length(); i++) {
			caracterDeContrasenia = contrasenia.charAt(i);
			if (Character.isLowerCase(caracterDeContrasenia)) {
				tieneUnaMinuscula = true;
			}
		}
		return tieneUnaMinuscula;
	}

	private static boolean verificarMayuscula(String contrasenia) {
		boolean tieneUnaMayuscula = false;
		Character caracterDeContrasenia;

		for (int i = 0; i < contrasenia.length(); i++) {
			caracterDeContrasenia = contrasenia.charAt(i);
			if (Character.isUpperCase(caracterDeContrasenia)) {
				tieneUnaMayuscula = true;
			}
		}
		return tieneUnaMayuscula;
	}

	private static boolean verficarLongitudContrasenia(String contrasenia) {
		int longitudContrasenia = contrasenia.length();
		boolean longitudCorrecta = false;

		if (longitudContrasenia >= 8) {
			longitudCorrecta = true;
		}
		return longitudCorrecta;
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
