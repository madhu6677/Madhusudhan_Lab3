package com.gl.lab3.algoritham;
import java.util.*;

public class PairSum {
	
	static final int MAX_SIZE= 100;
	 
		static class node{
	
	    int val;
	    node left, right;
	}
	 	
	static class Stack{
	
	    int size;
	    int top;
	    node []array;
	}
	 
	static Stack createStack(int size){
	
	    Stack stack = new Stack();
	    stack.size = size;
	    stack.top = -1;
	    stack.array = new node[stack.size];
	    return stack;
	}
	 
	static int isFull(Stack stack)
	{
	    return (stack.top - 1 == stack.size)?1:0 ;
	}
	 
	static int isEmpty(Stack stack)
	{
	    return stack.top == -1?1:0;
	}
	 
	static void push(Stack stack, node node)
	{
	    if (isFull(stack)==1)
	        return;
	    stack.array[++stack.top] = node;
	}
	 
	static node pop(Stack stack)
	{
	    if (isEmpty(stack) == 1)
	        return null;
	    return stack.array[stack.top--];
	}
	static boolean isPairPresent(node root, int target)
	{
	  Stack s1 = createStack(MAX_SIZE);
	  
	    Stack s2 = createStack(MAX_SIZE);
	 	   
	    boolean done1 = false, done2 = false;
	    int val1 = 0, val2 = 0;
	    node curr1 = root, curr2 = root;
	 
	     while (true){
	          
	         while (done1 == false){
	        
	          if (curr1 != null){
	            
	          push(s1, curr1);
	          curr1 = curr1.left;
	            }
	            else{
	            
	          if (isEmpty(s1) == 1)
	                    done1 = true;
	                else{
	                
	                    curr1 = pop(s1);
	                    val1 = curr1.val;
	                    curr1 = curr1.right;
	                    done1 = true;
	                }
	            }
	        }
	        while (done2 == false){
	        
	            if (curr2 != null){
	            
	                push(s2, curr2);
	                curr2 = curr2.right;
	            }
	            else {
	                if (isEmpty(s2) == 1)
	                    done2 = true;
	                else {
	                    curr2 = pop(s2);
	                    val2 = curr2.val;
	                    curr2 = curr2.left;
	                    done2 = true;
	                }
	            }
	        }
	 
	        if ((val1 != val2) && (val1 + val2) == target)
	        {
	        System.out.println("Pair is ( " +val1+","+val2+ " ) \nSum = "+target +"\n");
	                        
	            return true;
	        }
	      
	        else if ((val1 + val2) < target)
	            done1 = false;
	 
	        
	        else if ((val1 + val2) > target)
	            done2 = false;
	 
	       
	        if (val1 >= val2)
	            return false;
	    }
	}
	 	
	static node NewNode(int val)
	{
	    node tmp = new node();
	    tmp.val = val;
	    tmp.right = tmp.left = null;
	    return tmp;
	}
	 //Main method
		public static void main(String[] args)
	{
	   
	    node root = NewNode(40);
	    root.left = NewNode(20);
	    root.right = NewNode(60);
	    root.left.left = NewNode(10);
	    root.left.right = NewNode(30);
	    root.right.left = NewNode(50);
	    root.right.right = NewNode(70);
	 
	    int target = 130;
	    if (isPairPresent(root, target) == false)
	        System.out.print("\n Print Nodes  are Not Found\n");
	}
	}
	 

