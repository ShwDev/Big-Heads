# BigHeads

Mod de Fabric para Minecraft que permite ajustar el tamaño de la cabeza de los jugadores.

## Requisitos
- Minecraft 26.3
- Fabric Loader 0.19.5+
- Fabric API

## Instalación
1. Instalá Fabric Loader para tu versión de Minecraft
2. Descargá Fabric API y colocalo en tu carpeta `mods`
3. Descargá el .jar de este mod desde [Releases] y colocalo en `mods`

## Uso
/headscale <jugador> <escala>

Ejemplo: /headscale @s 2.0 duplica el tamaño de tu cabeza (visible en tercera persona).
Rango permitido: 0.1 a 5.0

## Cómo funciona
El mod usa Mixins para interceptar el render del modelo del jugador (`HumanoidModel`) y modificar la escala del `ModelPart` de la cabeza. Como esta versión de Minecraft usa una arquitectura de "render state" (el modelo no tiene acceso directo a la entidad jugador), el valor de escala se transporta a través del `AvatarRenderState`, inyectado en `AvatarRenderer.extractRenderState`.
