/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    
    if(prices.length < 2){
        return 0
    }
    
    let minNum = {
        amount : prices[0],
        index : 0
    }
    let maxNum = {
        amount : prices[0],
        index : 0
    }
    
    let prof = 0
    var i
    for(i = 1; i < prices.length; i++){
        /**
        * detremining the max and min 
        */
        if(prices[i] < minNum.amount){
            minNum.amount = prices[i]
            minNum.index = i
            maxNum.amount = 0
            maxNum.index = i
        }
        else{ 
            if(prices[i] > maxNum.amount){
                maxNum.amount = prices[i]
                maxNum.index = i
            }
        }
        let currProf
        if(prices[i] > prices[i-1]){
            currProf = prices[i]-prices[i-1]
            prof = prof + currProf
            if((minNum.index < i) && (prices[i]-prices[minNum.index] > prof)){

                prof = prices[i]-prices[minNum.index]
            }
        }
    }
    const diff = maxNum.amount - minNum.amount
    if(diff > prof){
        prof = diff
    }
    return prof
};
