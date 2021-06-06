function solve() {
   document.querySelector('.shopping-cart').addEventListener('click', createShoppingCart);
   document.querySelector('.checkout').addEventListener('click', checkOut);
   const resultField = document.querySelector('textarea');


   const boughtProducts = {
      totalPrice: 0,
      items: []
   }

   function createShoppingCart(ev){
      if(ev.target.tagName == 'BUTTON' && ev.target.classList.contains('add-product')){
         const itemDiv = ev.target.parentNode.parentNode;
         const productName = itemDiv.querySelector('.product-title').textContent;
         const productPrice = Number(itemDiv.querySelector('.product-line-price').textContent);

         boughtProducts.totalPrice += productPrice;

         if(boughtProducts.items.includes(productName) == false){
            boughtProducts.items.push(productName);
         }

         resultField.value += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`
      }
   }

   function checkOut(){
      resultField.value += `You bought ${boughtProducts.items.join(', ')} for ${boughtProducts.totalPrice.toFixed(2)}.`
      document.querySelector('.shopping-cart').removeEventListener('click', createShoppingCart);
      document.querySelector('.checkout').removeEventListener('click', checkOut);
   }
}