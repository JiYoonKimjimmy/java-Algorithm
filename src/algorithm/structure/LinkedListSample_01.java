package algorithm.structure;

/**
 * @author Jim, Kim
 * @since 2019-06-01
 */

/**
 * List를 구성하는 Node 클래스
 */
class ListNode {
    private String data;
    public ListNode link;

    public ListNode() {
        this.data = null;
        this.link = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.link = null;
    }

    public ListNode(String data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }
}

public class LinkedListSample_01 {

    private ListNode head;

    public LinkedListSample_01() {
        this.head = null;
    }

    /**
     * List 데이터 찾기
     * @param data
     * @return
     */
    public ListNode searchNode(String data) {
        ListNode tempNode = this.head;

        while (tempNode != null) {
            if (data.equals(tempNode.getData())) return tempNode;
            else tempNode = tempNode.link;
        }

        return null;
    }

    /**
     * List preNode 앞에 data 추가
     * @param preData
     * @param data
     */
    public void insertNode(String preData, String data) {
        ListNode newNode = new ListNode(data);

        ListNode preNode = searchNode(preData);

        /**
         * 현재 Node 의 link 는 기존 preNode 의 link 로 연결해주고,
         * 앞에 preNode 의 link 를 현재 Node 로 연결해준다.
         */
        newNode.link = preNode.link;
        preNode.link = newNode;
    }

    /**
     * List 마지막 노드에 data 추가
     * @param data
     */
    public void insertNode(String data) {
        ListNode newNode = new ListNode(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            ListNode tempNode = this.head;

            while (tempNode.link != null) {
                /**
                 * tempNode.link 가 null 이 아닌 경우
                 * 다음 node 가 참조되지 않은 마지막 node
                 */
                tempNode = tempNode.link;
            }

            // 마지막 node 가 현재 node 를 참조하게 된다.
            tempNode.link = newNode;
        }
    }

    /**
     * 마지막 Node 를 삭제
     */
    public void deleteNode() {
        ListNode preNode;
        ListNode tempNode;

        // head 가 null 이라면, 모든 Node 가 삭제된 경우
        if (this.head == null) return;

        if (this.head.link == null) {
            // head.link 가 null 인 경우는, Node 가 1개 인 경우, head 를 null 을 할당하여 남은 연결 끊음.
            this.head = null;
        } else  {
            preNode = this.head;

            tempNode = this.head.link;

            while(tempNode.link != null) {
                /**
                 * tempNode 의 link 가 null 이 아닐 때까지,
                 * 다음 Node 로 이동
                 */
                preNode = tempNode;
                tempNode = tempNode.link;
            }

            preNode.link = null;
        }
    }

    /**
     * 선택된 data 의 Node 삭제
     * @param data
     */
    public void deleteNode(String data) {
        ListNode preNode = this.head;
        ListNode tempNode = preNode.link;

        if (data.equals(preNode.getData())) {
            /**
             * 첫번째 Node 가 삭제되어야하는 경우
             * head 를 현재 head.link 로 변경하고,
             * 현재 head 의 link 의 연결을 끊어준다.
             */
            this.head = preNode.link;
            preNode.link = null;
        } else {
            while (tempNode != null) {
                // tempNode 가 null 이 될 때까지 data 와 일치한 Node 를 찾는다.
                if (data.equals(tempNode.getData())) {
                    if (tempNode.link == null) {
                        // tempNode 가 마지막 Node 인 경우
                        preNode.link = null;
                    } else {
                        /**
                         * tempNode 가 마지막 Node 가 아닌 경우
                         * preNode.link 를 tempNode.link 로 대체하고,
                         * tempNode.link 의 연결을 끊어준다.
                         */
                        preNode.link = tempNode.link;
                        tempNode.link = null;
                    }

                    break;
                } else {
                    // 일치한 데이터가 없는 경우
                    preNode = tempNode;         // 현재 tempNode 를 preNode 로 변경
                    tempNode = tempNode.link;   // 다음 Node 를 tempNode 로 변경
                }
            }
        }
    }

    /**
     * List 를 역순으로 전환
     */
    public void reverseList() {
        ListNode preNode, currentNode = null;
        ListNode nextNode = this.head;

        while (nextNode != null) {
            // nextNode 를 순차적으로 이동시키며, currentNode.link 가 preNode 를 참조할 수 있도록 한다.

            // 1. currentNode 를 preNode 로 이동
            preNode = currentNode;

            // 2. nextNode 를 currentNode 로 이동
            currentNode = nextNode;

            // 3. nextNode 는 다음 Node 로 이동
            nextNode = nextNode.link;

            // 4. currentNode.link 는 preNode 를 참조
            currentNode.link = preNode;
        }

        // currentNode 가 마지막 Node 를 가리킬 때까지, head 는 currentNode 를 참조한다.
        this.head = currentNode;
    }

    /**
     * print List Data
     */
    public void printList()  {
        ListNode tempNode = this.head;

        int index = 0;

        while (tempNode != null) {
            // tempNode.link 는 다음 Node 이므로, 다음 Node 가 null 이 될 때까지 List Data 출력
            System.out.println(index + " : " + tempNode.getData());
            tempNode = tempNode.link;
            index++;
        }

        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        LinkedListSample_01 list = new LinkedListSample_01();

        // 순서대로 list 에 추가
        list.insertNode("a");
        list.insertNode("b");
        list.insertNode("c");
        list.insertNode("d");

        // list 를 역순으로 구성
        list.reverseList();
        list.printList();

        // "b" 뒤에 "d" 추가
        list.insertNode("b", "d");
        list.printList();

        // 마지막 노트 삭제
        list.deleteNode();
        list.printList();

        // 임의의 데이터 삭제
        list.deleteNode("b");
        list.printList();
    }
}
