function comp(array1, array2){
  if (array1 == null || array2 == null)
    return false;
  for (var i = 0; i < array2.length; i++){
    array2[i] = Math.sqrt(array2[i]);
    if (array2[i] % 1 != 0)
      return false;
  }
  array1.sort();
  array2.sort();
  for (var i = 0; i < array2.length; i++){
    if (array2[i] != array1[i])
      return false;
  }
  return true;
}