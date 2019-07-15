public class Calculator2 {
//	declare two operands, two operators, and a total; also declare booleans for if they contain something
	private double operand1;
	private double operand2;
	private String operator1;
	private String operator2;
	private double total;
	private boolean operand1Set = false;
	private boolean operand2Set = false;
	private boolean operator1Set = false;
	private boolean operator2Set = false;
	private boolean totalSet = false;

	public Calculator2() {
	}

//	If a double is entered:
	public void performOperation(double operand) {
//		if operand1 is not set - set it to the entered operand and mark that operand1 has been set
		if (this.operand1Set) {
			this.operand1 = operand;
			this.operand1Set = true;
//		if operator1 is set and operand2 is not set:
		} else if (operator1Set && !operand2Set) {
//			if operator1 is "*" set operand 1 to be operand1 multiplied by entered operand and set operator1Set to be false - only one operand1 left set
			if (this.operator1 == "*") {
				this.operand1 = this.operand1 * operand;
				this.operator1Set = false;
//			if operator1 is "/" set operand 1 to be operand1 divided by entered operand and set operator1Set to be false - only one operand1 left set
			} else if (this.operator1 == "/") {
				this.operand1 = this.operand1 / operand;
				this.operator1Set = false;
//			if operator 1 is "+" or "-" set operand2 to be entered operand and mark that oeprand2 has been set
			} else {
				this.operand2 = operand;
				this.operand2Set = true;
			}
//		if operator1, operand2, and operator2 is set:
		} else if (operator1Set && operand2Set && operator2Set) {
//			if operator2 is "*" set operand2 to operand2 multiplied by entered operand and mark operator2Set as false - operand1, operator1, operand2 set
			if (this.operator2 == "*") {
				this.operand2 = this.operand2 * operand;
				this.operator2Set = false;
//			if operator2 is "/" set operand2 to operand2 divided by entered operand and mark operator2Set as false - operand1, operator1, operand2 set
			} else if (this.operator2 == "/") {
				this.operand2 = this.operand2 / operand;
				this.operator2Set = false;
//			if operator2 is "+" or "-":
			} else {
//				if operator1 is "+" add operand2 to operand1
				if (this.operator1 == "+") {
					this.operand1 += this.operand2;
//				if operator1 is "-" subtract operand2 to operand1
				} else {
					this.operand1 -= this.operand2;
				}
//				set operator1 to operator2, operator2 is now not set, operand2 is now the entered operand
				this.operator1 = this.operator2;
				this.operator2Set = false;
				this.operand2 = operand;
			}
//		If anything else is entered throw an error because it should not be processed
		} else {
			throw new IllegalThreadStateException();
		}
	}

//	If a String is entered:
	public void performOperation(String operator) {
//		If the entered operator is "=" a total needs to be calculated and set
		if (operator == "=") {
//			if there isn't and operand2 set then the total is just operand1
			if (!this.operand2Set) {
				this.total = this.operand1;
//			if there is an operand2 and operator 1 is "+" set the total to the sum of operand1 and operand2
			} else if (this.operator1 == "+") {
				this.total = this.operand1 + this.operand2;
//			if there is an operand2 and operator1 is "-" set the total to the difference of operand1 and operand2
			} else if (this.operator1 == "-") {
				this.total = this.operand1 - this.operand2;
//			in any other situation a total should not be able to be calculated so throw an error
			} else {
				throw new IllegalThreadStateException();
			}
//			mark that a total has been set
			totalSet = true;
//		if the entered operator is one of the operations this calculator processes:
		} else if (operator == "*" || operator == "/" || operator == "+" || operator == "-") {
//			mark that a total is not set so a result cannot be produced if the last thing entered is one of these operators
			totalSet = false;
//			if operand1 is set and operator1 is not set: set operator1 to the entered operator and mark that it's been set
			if (this.operand1Set && !this.operator1Set) {
				this.operator1 = operator;
				this.operator1Set = true;
//			if operand1, operator1, and operand2 are set and operator2 is not set: set operator2 to entered operator and mark that it's been set
			} else if (this.operand1Set && this.operator1Set && this.operand2Set && !this.operator2Set) {
				this.operator2 = operator;
				this.operator2Set = true;
//			in any other case a operator should not have been entered so throw an error
			} else {
				throw new IllegalThreadStateException();
			}
//		if any other String is entered throw and error
		} else {
			throw new UnsupportedOperationException();
		}
	}

//	If a total is set print the total. Otherwise a final total has not been calculated so throw and error
	public void getResults() {
		if (totalSet == true) {
			System.out.println(this.total);
		} else {
			throw new IllegalThreadStateException();
		}
	}
}