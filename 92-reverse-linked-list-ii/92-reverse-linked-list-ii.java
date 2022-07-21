/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null ||left==right)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        ListNode startPrev = null;
        int n =1;
        while(curr != null && n<left){
            startPrev = curr;
            curr = curr.next;
            n++;
        }
       // prev = startPrev;
        ListNode start = curr;
        //startPrev= startPrev == null ? null : curr;
        while(curr != null && n<=right){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n++;
        }
        if(startPrev==null){
            head = prev;
            start.next = next;
        }
        if(startPrev != null){
            startPrev.next = prev;
            start.next=next;
        }
        
        return head;
    }
}