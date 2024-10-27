package com.matheusjfa.codeflix.admin.domain.exceptions;

public class NoStackTraceException extends RuntimeException {
  public NoStackTraceException(String message) {
    super(message);
  }
}
