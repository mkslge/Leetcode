class Solution(object):
    def evalRPN(self, tokens):
        #set that saves operations
        op_set = ["*","+","-","/"]
        #stack
        stack = []

        #go through tokens 
        for i in range(0,len(tokens)):
            #if the token is an operation we know theres two numbers on the stack
            #so we grab them and perform the operation
            if tokens[i] in op_set:
                #most recent one grabbed first
                i2 = int(stack.pop())
                i1 = int(stack.pop())
                #adding
                if tokens[i] == "+":
                    stack.append(int(i1 + i2))
                elif tokens[i] == "-":
                    #subtracting
                    stack.append(int(i1 -i2))
                elif tokens[i] == "/":
                    #make sure truncation works
                    stack.append(int(i1 / i2) if i1 * i2 >= 0 else -(-i1 // i2))
                elif tokens[i] == "*":
                    #multiplying
                    stack.append(int(i1 * i2))
            else:
                #otherwise we know its an int and add it to the stack
                stack.append(int(tokens[i]))
        #since we can assume all operations are valid there will always
        #be only one thing on the stack at the end
        return stack.pop()
        
