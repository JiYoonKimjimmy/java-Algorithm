package algorithm.structure;

import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-06-01
 */
interface Stack {
    boolean isEmpty();
    boolean isFull();
    void clear();
    void push(String data);
    String pop();
    String peek();
}

public class StackSample_01 implements Stack {

    private int top;        // stack의 최상단 index
    private int stackSize;  // stack 사이즈
    private String[] stack; // stack

    public StackSample_01(int stackSize) {
        this.top = -1;
        this.stackSize = stackSize;
        this.stack = new String[stackSize];
    }

    @Override
    public boolean isEmpty() {
        // 현재 top이 -1 이라면 데이터가 없는 상태
        return this.top == -1;
    }

    @Override
    public boolean isFull() {
        // 현재 top이 stack size - 1 이라면 데이터 full 상태
        return this.top == this.stackSize - 1;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            System.out.println("Stack is already empty!!");
        } else {
            // stack 상태 모두 초기화
            this.top = -1;
            this.stack = new String[this.stackSize];
        }
    }

    @Override
    public void push(String data) {
        if (isFull()) {
            System.out.println("Stack is already Full!!");
        } else {
            // top에 데이터 추가
            this.stack[++this.top] = data;
        }
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            System.out.println("Pop fail! Stack is already empty!!");
            return "empty";
        } else {
            // 데이터 반환하고 top을 -1하면, 데이터 제거
            return stack[--this.top];
        }
    }

    @Override
    public String peek() {
        if (isEmpty()) {
            System.out.println("Peek fail! Stack is already empty!!");
            return "empty";
        } else {
            // 데이터 제거 없이 데이터만 반환
            return stack[this.top];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stackSize = sc.nextInt();

        StackSample_01 stack = new StackSample_01(stackSize);

        for (int i = 0; i < stackSize; i++) {
            String data = sc.next();
            stack.push(data);
        }

        System.out.println("----------peek test---------");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println("----------pop test---------");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}