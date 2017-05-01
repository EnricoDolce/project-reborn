#!/bin/bash

#vedi javaDoc
percorso=$1
file=$2
imgFile=$3
cartellaDownload=$4
cartellaImg=$5
loop=0
d='debug.txt'
#TODO fixare nomi file senza 2 spazi (comunicazione 21)
#DONE finalizzare processo di controllo
cat "$imgFile" | while read -r nome  #controlla se le immagini sono state create correttamente
do
	if [ $loop == 0 ];
	then
		loop=1
		rm "$imgFile"
	fi
	lunghezza=${#nome}-4  #senza il .pdf
	temp="${nome:0:lunghezza}_0.jpg"
	if [ ! -e "$cartellaImg$temp" ];  #se non esiste
	then
		echo "$nome" >> "$imgFile"  #aggiunge il file a quelli da renderizzare (*.txt)
	fi
done
lynx -dump -listonly 192.168.1.16 | grep "$percorso" | cut -f2- -d "." > "$file"  #scarica i link delle comunicazioni

cd $cartellaDownload 
cut -f5 -d '/' < "$file" | while read -r nome  #controlla se il file è già stato scaricato, altrimenti procede al download
do
	lunghezza=${#nome}-4  #senza il .pdf
	temp="${nome:lunghezza:lunghezza+4}"
	if [ $temp == ".pdf" ];
	then
		if [ ! -e "$nome" ];
		then
			wget -q -P "$cartellaDownload" "$percorso/$nome"  #scarica il .pdf corrispondente
			echo "$nome" >> "$imgFile"  #aggiunge il file a quelli da renderizzare (*.txt)
		fi
	fi
done



