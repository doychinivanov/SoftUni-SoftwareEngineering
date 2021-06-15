function notify(message) {
  const notificationHolder = document.getElementById('notification');
  notificationHolder.addEventListener('click', (ev)=>ev.target.style.display = 'none');
  notificationHolder.textContent = message;
  notificationHolder.style.display = 'block';
}