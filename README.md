# Text to Speech in Java

Simple use of the IBM Watson API (Text to Speech)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What you need to develop code and how to run it

```
Java 1.8 or >
Netbeans 8.2 or >
An account at IBM
```

## Libs

* [Cloud IBM](https://cloud.ibm.com/) - Framework used in the project.

### Installing

Follow this video to understand step-by-step to create the project

```
https://www.youtube.com/watch?v=94SHvsoNkv0
```

To get these two attributes, you must register on the IBM Watson (Cloud) website and follow the steps in the video.

    String API_KEY = "YOUR_API_KEY";
    String URL = "YOUR_URL";
    
To list the available voices in the system, you must use:

    new SoundCreator().list_voices();
    
    The voice for which information is to be returned.

    Allowable values: [de-DE_BirgitVoice,
    de-DE_BirgitV2Voice,
    de-DE_DieterVoice,
    de-DE_DieterV2Voice,
    en-GB_KateVoice,
    en-US_AllisonVoice,
    en-US_AllisonV2Voice,
    en-US_LisaVoice,
    en-US_LisaV2Voice,
    en-US_MichaelVoice,
    en-US_MichaelV2Voice,
    es-ES_EnriqueVoice,
    es-ES_LauraVoice,
    es-LA_SofiaVoice,
    es-US_SofiaVoice,
    fr-FR_ReneeVoice,
    it-IT_FrancescaVoice,
    it-IT_FrancescaV2Voice,
    ja-JP_EmiVoice,
    pt-BR_IsabelaVoice]

## Authors

* **Abner Rodrigues** - *Initial work* - [KingAspx](https://github.com/kingaspx)

## Screenshot

![Screenshot_1](https://user-images.githubusercontent.com/40338524/58808996-76e76700-85f1-11e9-846a-de6b822d478d.png)

![Screenshot_2](https://user-images.githubusercontent.com/40338524/58808999-76e76700-85f1-11e9-8314-ee6137802deb.png)
