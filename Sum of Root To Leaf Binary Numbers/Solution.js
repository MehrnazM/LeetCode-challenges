/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
class Solution{
    
    constructor() {
        this._totSum = 0;
    }
    parSum(node,sum){
        if(node != null){
        sum = sum + node.val.toString();
        if(node.left === null && node.right === null){
          this._totSum = this._totSum + parseInt(sum,2);
        }
        this.parSum(node.left,sum);
        this.parSum(node.right,sum);
        } 
    }

    get totSum(){
        return this._totSum;
    }
}

var sumRootToLeaf = function(root) {
    sol = new Solution();
    sol.parSum(root,"0");
    
    return sol.totSum;
};
