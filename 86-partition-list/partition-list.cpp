/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* x1= new ListNode(-1);
        ListNode* x2= new ListNode(-1);
        ListNode* dummy1=x1;
        ListNode* dummy2=x2;
        while(head!=NULL){
            if(head->val<x){
                dummy1->next=head;
                dummy1=dummy1->next;
            }
            else{
                dummy2->next=head;
                dummy2=dummy2->next;
            }
            head=head->next;
        }
        dummy1->next=x2->next;
        dummy2->next=NULL;
        return x1->next;
    }
};