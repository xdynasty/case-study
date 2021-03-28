$(() => {
  let flashMsgs = [
    'Import Fees Included',
    'Free Express Shipping Over $500',
    'CNY Sale',
  ];
  let flashMsgI = 0;
  let flashEle = $('#flash');
  flashEle.text(flashMsgs[0]);

  function changeCurrFlashMsg() {
    flashMsgI = (flashMsgI + 1) % flashMsgs.length;
    flashEle.text(flashMsgs[flashMsgI]);
  }

  setInterval(changeCurrFlashMsg, 1500);
});
