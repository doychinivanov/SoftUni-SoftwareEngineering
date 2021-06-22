(function extendArrayProto(){
    Array.prototype.last = function(){
        return this[this.length-1];
    };

    Array.prototype.skip = function(n=0){
        n = Number(n);

        if(!n && n != 0){
            throw new TypeError('Invalid parameter. Skip requires a number.');
        }

        return this.slice(n);
    };

    Array.prototype.take = function(n){
        n = Number(n);

        if(!n && n != 0){
            throw new TypeError('Invalid parameter. Skip requires a number.');
        }

        return this.slice(0, n);
    }

    Array.prototype.sum = function(){
        return this.reduce((acc,cur) => acc+ cur,0);
    };

    Array.prototype.average = function(){
        return this.reduce((acc,cur) => acc+ cur,0) / this.length;
    }

})();

const arr = [1, 5, 4];
console.log(arr.take(1))