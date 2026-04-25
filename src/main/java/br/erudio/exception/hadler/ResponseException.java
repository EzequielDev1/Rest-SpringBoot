package br.erudio.exception.hadler;

import java.io.Serializable;
import java.util.Date;

public record ResponseException(Date date, String message, String description) implements Serializable {}