# Guía: Gestión de Consultas Premium en VSCode

## Problema: "No me quedan consultas premium"

Este documento explica qué hacer cuando se agotan las consultas premium de GitHub Copilot en VSCode.

## ¿Qué son las consultas premium?

GitHub Copilot utiliza un sistema de cuotas que limita:
- Número de sugerencias de código
- Completaciones automáticas
- Generación de código mediante chat
- Explicaciones de código

## Causas Comunes

1. **Uso intensivo**: Solicitar muchas sugerencias en poco tiempo
2. **Sesiones largas**: Mantener Copilot activo durante muchas horas
3. **Tipo de plan**: Plan gratuito con límites más restrictivos
4. **Período de facturación**: Cuota mensual agotada

## Soluciones Inmediatas

### 1. Verificar Estado de Suscripción

1. Ve a [GitHub Copilot Settings](https://github.com/settings/copilot)
2. Verifica tu plan actual y límites
3. Revisa la fecha de renovación

### 2. Gestionar el Uso de Copilot

**Desactivar temporalmente:**
```
Ctrl+Shift+P (o Cmd+Shift+P en Mac)
> "GitHub Copilot: Disable Completions"
```

**Activar solo para lenguajes específicos:**

Edita tu `settings.json` en VSCode:
```json
{
  "github.copilot.enable": {
    "*": false,
    "kotlin": true,
    "java": true,
    "xml": true
  }
}
```

### 3. Optimizar Configuración

**Reducir sugerencias automáticas:**
```json
{
  "editor.inlineSuggest.enabled": true,
  "github.copilot.inlineSuggest.enable": false,
  "github.copilot.editor.enableAutoCompletions": false
}
```

**Usar Copilot solo a demanda:**
- Usa `Alt+\` (o `Option+\` en Mac) para solicitar sugerencias manualmente
- Desactiva las sugerencias automáticas
- Activa Copilot solo cuando realmente lo necesites

## Alternativas para Desarrollo Android/Kotlin

### 1. Android Studio (RECOMENDADO)

**Ventajas:**
- IDE oficial de Google para Android
- Autocompletado inteligente incluido
- Refactorización automática
- Análisis estático de código
- Sin límites de uso

**Descarga:**
- [Android Studio](https://developer.android.com/studio)

**Características destacadas:**
- Live Templates para código repetitivo
- Inspecciones de código en tiempo real
- Sugerencias contextuales
- Generación automática de código

### 2. IntelliJ IDEA Community

**Ventajas:**
- Excelente soporte para Kotlin
- Gratuito y de código abierto
- Refactorización avanzada
- Navegación inteligente por el código

**Descarga:**
- [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/)

### 3. Extensiones Gratuitas para VSCode

**Kotlin Language:**
- Autocompletado básico
- Syntax highlighting
- Navegación de código

**Android IDE:**
- Soporte para desarrollo Android en VSCode
- Integración con Gradle

## Consejos para Estudiantes

### Mejores Prácticas

1. **Aprende la sintaxis básica**: No dependas completamente de la IA
2. **Usa documentación oficial**: 
   - [Kotlin Docs](https://kotlinlang.org/docs/home.html)
   - [Android Developer](https://developer.android.com/)
3. **Practica sin asistencia**: Escribe código manualmente para aprender mejor
4. **Usa Copilot estratégicamente**: Reserva para código complejo o repetitivo

### Recursos Gratuitos de Aprendizaje

- **Kotlin Koans**: Ejercicios interactivos de Kotlin
- **Android Codelabs**: Tutoriales paso a paso de Google
- **Stack Overflow**: Comunidad de desarrolladores
- **Kotlin Playground**: Editor online gratuito

## Plan de Acción Recomendado

### Corto Plazo (Ahora)
1. ✅ Desactiva Copilot temporalmente
2. ✅ Usa Android Studio para proyectos Android
3. ✅ Reserva VSCode para archivos de texto/markdown

### Mediano Plazo (Esta Semana)
1. ✅ Aprende atajos de teclado de tu IDE
2. ✅ Configura Live Templates en Android Studio
3. ✅ Practica escribir código sin asistencia

### Largo Plazo (Este Mes)
1. ✅ Considera si necesitas GitHub Copilot Pro
2. ✅ Evalúa alternativas según tu presupuesto
3. ✅ Mejora tus habilidades de programación fundamentales

## Configuración .vscode Recomendada

Crea o edita `.vscode/settings.json` en tu proyecto:

```json
{
  // Configuración de Copilot
  "github.copilot.enable": {
    "*": false,
    "kotlin": true,
    "java": true
  },
  
  // Configuración de editor
  "editor.formatOnSave": true,
  "editor.codeActionsOnSave": {
    "source.organizeImports": true
  },
  
  // Kotlin específico
  "kotlin.compiler.jvm.target": "1.8",
  
  // Android
  "java.configuration.updateBuildConfiguration": "automatic"
}
```

## Preguntas Frecuentes

**P: ¿Cuándo se reinician las consultas?**
R: Generalmente al inicio de cada mes de facturación.

**P: ¿Puedo obtener más consultas gratis?**
R: Los estudiantes pueden solicitar GitHub Student Developer Pack para acceso gratuito.

**P: ¿Es necesario Copilot para aprender?**
R: No. Muchos desarrolladores excelentes aprendieron sin asistentes IA. Es una herramienta útil pero no esencial.

**P: ¿Qué IDE es mejor para este curso?**
R: Android Studio es el más recomendado para desarrollo Android.

## Enlaces Útiles

- [GitHub Education](https://education.github.com/) - Beneficios para estudiantes
- [Android Studio](https://developer.android.com/studio) - IDE oficial
- [Kotlin Playground](https://play.kotlinlang.org/) - Editor online
- [Stack Overflow](https://stackoverflow.com/questions/tagged/kotlin) - Comunidad de ayuda

---

**Última actualización**: Diciembre 2025
