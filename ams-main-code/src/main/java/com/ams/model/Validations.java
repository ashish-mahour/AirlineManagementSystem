package com.ams.model;

import java.util.ArrayList;

import javax.swing.JTextField;

public class Validations {
	public static boolean validateTextField(ArrayList<JTextField> list) {
		for(JTextField x : list) {
			if(x.getText().trim().isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
