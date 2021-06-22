(function extendStringProto(){
    String.prototype.ensureStart = function(str){
        if(this.toString().startsWith(str)){
            return this.toString();
        } else {
            return str+this.toString();
        }
    }

    String.prototype.ensureEnd = function(str){
        if(this.toString().endsWith(str.trim())){
            return this.toString();
        } else {
            return this.toString() + str;
        }
    }

    String.prototype.isEmpty = function(){
        if(this.toString() == ''){
            return true;
        } else {
            return false;
        }
    }

    String.prototype.truncate = function (n) {
        if (n <= 3) {
            return ".".repeat(n);
        }
        if (this.toString().length <= n) {
            return this.toString();
        } else {
            let lastIndex = this.toString().substr(0, n - 2).lastIndexOf(" ");
            if (lastIndex != -1) {
                return this.toString().substr(0, lastIndex) + "...";
            } else {
                return this.toString().substr(0, n - 3) + "...";
            }
        }
    };

    String.format = function(str, ...params){
        params.forEach((v, i) => str = str.replace(new RegExp(`\\{${i}\\}`, 'g'), v));

        return str;
    }

})();

let str = 'my string';
str = str.ensureStart('my');
console.log(str);
str = str.ensureStart('hello ');
console.log(str);
str = str.truncate(16);
console.log(str);
str = str.truncate(14);
console.log(str);
str = str.truncate(8);
console.log(str);
str = str.truncate(4);
console.log(str);
str = str.truncate(2);
console.log(str);
str = String.format('The {0} {0} {1} fox',
  'quick', 'brown');
str = String.format('jumps {0} {1}',
  'dog');
