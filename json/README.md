###Json examples

Custom serializing and deserializing using Jackson.
Main goal was to replace field **id** at runtime while serializing/deserializing. This case appeared with mongo **_id**
mongo **ObjcetId** field while saving/retrieving mongo docs. Didn't want to have DB dependencies in module **model** and wasn't using
object mapping frameworks in project. All work with mongo through object-JSON serialization and native mongo driver.

1. Example of **BeanSerializerModifier** extend and overriding.
2. Example of **BeanDeserializerModifier** extend and overriding.