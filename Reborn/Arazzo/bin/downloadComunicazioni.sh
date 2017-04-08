#!/bin/bash

percorso="http://192.168.1.16/comunicazioni"
file='link.txt'
imgFile='toImg.txt'
cartellaDownload="/home/arazzo/Arazzo/resources/pdf"

cd $cartellaDownload
rm $imgFile
touch $imgFile
lynx -dump -listonly 192.168.1.16 | grep "$percorso" | cut -f2- -d "." > "$file"  #scarica i link delle comunicazioni

cut -f5 -d '/' < "$file" | while read -r nome  #controlla se il file è già stato scaricato, altrimenti procede al download
do
	if [ ! -e "$nome" ];
	then
		wget -q -P "$cartellaDownload" "$percorso/$nome"
		echo "$nome" >> "$imgFile"
	fi
done



