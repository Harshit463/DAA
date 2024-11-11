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
    ListNode* merge(ListNode *head1, ListNode *head2) {
        if (head1 == NULL) {
            return head2;
        }
        if (head2 == NULL) {
            return head1;
        }

        ListNode *head = new ListNode(-1);
        ListNode *tail = head;

        while (head1 && head2) {
            if (head1->val <= head2->val) {
                tail->next = head1;
                head1 = head1->next;
                tail = tail->next;
                tail->next = NULL;
            }
            else {
                tail->next = head2;
                head2 = head2->next;
                tail = tail->next;
                tail->next = NULL;
            }
        }

        if (head1) {
            tail->next = head1;
        }

        if (head2) {
            tail->next = head2;
        }

        return head->next;
    }

    void mergeSort(vector<ListNode*>& lists, int s, int e) {
        if (s >= e) {
            return;
        }

        int mid = s + (e -s)/2;

        mergeSort(lists, s, mid);
        mergeSort(lists, mid+1, e);

        lists[s] = merge(lists[s], lists[mid+1]);
    }

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int k = lists.size();

        if (k == 0) {
            return NULL;
        }
        if (k == 1) {
            return lists[0];
        }

        mergeSort(lists, 0, k-1);
        return lists[0];
    }
};