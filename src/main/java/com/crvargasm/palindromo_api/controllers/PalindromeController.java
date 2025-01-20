package com.crvargasm.palindromo_api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controlador para verificar palindromos.
 */
@RestController
public class PalindromeController {

  /**
   * Endpoint para verificar si la palabra es un palíndromo.
   * @param word La palabra a verificar.
   * @return Un mensaje indicando si la palabra es un palíndromo o no.
   */
  @GetMapping("/palindrome/{word}")
  public String Palindrome(@PathVariable String word) {
    if (isPalindrome(word)) {
      return "La palabra " + word + " es palíndroma 🤗";
    }
    return "La palabra " + word + " no es palíndroma 🙁";
  }

  // Esto NO es una buena práctica, la lógica debe estar separada del controlador.
  /**
   * Método para verificar si la palabra es un palíndromo.
   * @param word La palabra a verificar.
   * @return true si la palabra es un palíndromo, false si la palabra no es un palíndromo.
   */
  private boolean isPalindrome(String word) {
    int length = word.length();
    boolean result = false;
    for (int i = 0; i < length / 2; i++) {
      result = word.charAt(i) == word.charAt(length - 1 - i) ? true : false;
    }
    return result;
  }
}