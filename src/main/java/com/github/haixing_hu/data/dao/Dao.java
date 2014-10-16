/*
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.github.haixing_hu.data.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.github.haixing_hu.criteria.Criterion;
import com.github.haixing_hu.data.model.Entity;
import com.github.haixing_hu.sort.Sort;

/**
 * The interface of a generic Data Access Object (DAO), providing the common
 * CURD operations of entities.
 * <p>
 * Note that the implementation of this interface is <b>NOT</b> required to be
 * thread-safe, and in fact a {@link Dao} object is intended to be used in a
 * single thread only.
 *
 * @param <ID>
 *          the type of identifiers of entities, which must be serializable.
 * @param <ENTITY>
 *          the type of entities, which must be an implementation of
 *          {@link Entity}.
 * @author Haixing Hu
 */
@NotThreadSafe
public interface Dao<ID extends Serializable, ENTITY extends Entity<ID>> {

  /**
   * Tests whether there is any entity exists in the underlying data store.
   *
   * @return {@code true} if there is any entity exists in the underlying data
   *         store; {@code false} otherwise.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public boolean exists() throws DataAccessException;

  /**
   * Tests whether the entity with the specified ID exists in the underlying
   * data store.
   *
   * @param id
   *          the identifier of an entity, which cannot be {@code null}.
   * @return {@code true} if the entity with the specified ID exists in the
   *         underlying data store; {@code false} otherwise.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public boolean exists(ID id) throws DataAccessException;

  /**
   * Tests whether the entity satisfying the specified criterion exists in the
   * underlying data store.
   *
   * @param criterion
   *          a specified criterion. It could be {@code null}, indicating no
   *          specified criterion.
   * @return {@code true} if the entity satisfying the specified criterion
   *         exists in the underlying data store; {@code false} otherwise.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public boolean exists(@Nullable Criterion criterion)
      throws DataAccessException;

  /**
   * Counts the total number of entities in the underlying data store.
   *
   * @return the total number of entities in the underlying data store.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public long count() throws DataAccessException;

  /**
   * Counts the entities satisfying the specified criterion.
   *
   * @param criterion
   *          a specified criterion, which cannot be {@code null}.
   * @return the number of entities satisfying the specified criterion.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public long count(Criterion criterion) throws DataAccessException;

  /**
   * Gets the entity with the specified ID.
   *
   * @param id
   *          an identifier, which cannot be {@code null}.
   * @return the entity with the specified ID, or {@code null} if no such
   *         entity.
   * @throws DataAccessException
   *           if any other data access error occurs.
   */
  public ENTITY get(ID id) throws DataAccessException;

  /**
   * Gets the list of entities with the specified IDs.
   *
   * @param ids
   *          a list of of identifiers, which cannot be {@code null}.
   * @return a list of entities with the corresponding ID in the specified ID
   *         list. If there is no entity for a certain ID, the corresponding
   *         entity in the returned list is {@code null}.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public List<ENTITY> get(List<ID> ids) throws DataAccessException;

  /**
   * Lists all the entities.
   * <p>
   * NOTE: If there are too many entities, calling this function will be very
   * slow and may cause an out of memory error. Therefore, it's better to call
   * the {@link #list(PageRequest)} function.
   *
   * @return a list of entities sorted using the default orders. If there is no
   *         entity, the function will return an empty list. Note that the
   *         returned list and objects in the returned list will never be
   *         {@code null}.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public List<ENTITY> list() throws DataAccessException;

  /**
   * Lists the entities.
   *
   * @param pageRequest
   *          encapsulates the pagination requirements.
   * @return the specified page of entities. If there is no entities satisfies
   *         the specified pagination requirements, the function will return an
   *         empty page. Note that the content of the returned page and elements
   *         in the content of the returned page will never be {@code null}.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public Page<ENTITY> list(PageRequest pageRequest) throws DataAccessException;

  /**
   * Finds all the entities satisfying a specified criterion and sort the result
   * using the specified orders.
   *
   * @param criterion
   *          a specified criterion used to filter the entities.
   * @param sort
   *          a sorting rule specifies the way to sort the result. A
   *          {@code null} value indicating no sorting rule.
   * @return a list of entities satisfying the specified criterion and sorted
   *         using the specified orders. If there is no entities satisfies the
   *         specified criterion, the function will return an empty list. Note
   *         that the returned list and elements in the returned list will never
   *         be {@code null}.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public List<ENTITY> find(Criterion criterion, @Nullable Sort sort)
      throws DataAccessException;

  /**
   * Finds all the entities satisfying a specified criterion, and returns the
   * result using the specified pagination requirements.
   *
   * @param criterion
   *          a specified criterion used to filter the entities.
   * @param pageRequest
   *          encapsulates the pagination requirements.
   * @return the specified page of entities satisfying the satisfying the
   *         specified criterion. If there is no entities satisfies the
   *         specified criterion, the function will return an empty page. Note
   *         that the content of the returned page and elements in the content
   *         of the returned page will never be {@code null}.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public Page<ENTITY> find(Criterion criterion, PageRequest pageRequest)
      throws DataAccessException;

  /**
   * Finds the first the entities satisfying a specified criterion, sorting the
   * result using the specified orders.
   *
   * @param criterion
   *          a specified criterion used to filter the entities.
   * @param sort
   *          a sorting rule specifies the way to sort the result. A
   *          {@code null} value indicating no sorting rule.
   * @return the first entity satisfying the specified criterion, using the
   *         specified sorting rule; or {@code null} if no such entity.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public ENTITY findFirst(Criterion criterion, @Nullable Sort sort)
      throws DataAccessException;

  /**
   * Adds an entity to the underlying data storage, and generate an ID for the
   * entity.
   * <p>
   * If the identifier of the entity is configured to be an automatically
   * generated field, after calling this function, the identifier property of
   * the specified entity will be set to the newly generated value.
   * <p>
   * After calling this function, this {@link Dao} object will <b>NEVER</b> keep
   * the reference to the entity passed as argument of this function. Therefore
   * changing the state of the argument object after calling this function will
   * <b>NOT</b> change the object persisted by this function.
   *
   * @param entity
   *          an entity object, which cannot be {@code null}.
   * @throws DataAccessException
   *           if any data access error occurs, or the there is already an
   *           entity with the same ID exists.
   */
  public void add(ENTITY entity) throws DataAccessException;

  /**
   * Adds a collection of entities to the underlying data storage.
   * <p>
   * If the identifier of the entity is configured to be an automatically
   * generated field, after calling this function, the identifier property of
   * every entity in the specified collection will be set to the newly generated
   * value, and therefore the collection <b>CAN NOT</b> be a hash set, since the
   * hash value of every entity in the collection will be changed.
   * <p>
   * After calling this function, this {@link Dao} object will <b>NEVER</b> keep
   * the reference to the entities passed as argument of this function. Thus
   * changing the state of the argument objects after calling this function will
   * <b>NOT</b> change the objects persisted by this function.
   *
   * @param entities
   *          a collection of entity objects, which cannot be {@code null}.
   * @throws DataAccessException
   *           if any data access error occurs, or the there is already an
   *           entity with the same ID exists.
   */
  public void add(Collection<ENTITY> entities) throws DataAccessException;

  /**
   * Updates an entity in the underlying data storage.
   * <p>
   * After calling this function, this {@link Dao} object will <b>NEVER</b> keep
   * the reference to the entity passed as argument of this function. Thus
   * changing the state of the argument objects after calling this function will
   * <b>NOT</b> change the object persisted by this function.
   *
   * @param entity
   *          an entity object, which cannot be {@code null}. Its identifier
   *          field must be set before calling this function, since the function
   *          will identify the entity to be updated solely by its identifier.
   * @throws DataAccessException
   *           if there is no entity in the underlying data storage with the
   *           same identifier as the argument entity; or any data access error
   *           occurs.
   */
  public void update(ENTITY entity) throws DataAccessException;

  /**
   * Updates a collection of entities in the underlying data storage.
   * <p>
   * After calling this function, this {@link Dao} object will <b>NEVER</b> keep
   * the reference to the entity passed as argument of this function. Thus
   * changing the state of the argument objects after calling this function will
   * <b>NOT</b> change the objects persisted by this function.
   * </p>
   *
   * @param entities
   *          a collection of entity objects, which cannot be {@code null}, and
   *          none of the elements in it can be {@code null}. The identifiers of
   *          elements in this collection must be set before calling this
   *          function, since the function will identify the entity to be
   *          updated solely by its identifier.
   * @throws DataAccessException
   *           if there is no entity in the underlying data storage with the
   *           same ID as any of the argument entities; or any data access error
   *           occurs.
   */
  public void update(Collection<ENTITY> entities) throws DataAccessException;

  /**
   * Updates a specified property of the specified entities.
   *
   * @param property
   *          the name of the property to be updated, which cannot be
   *          {@code null}.
   * @param value
   *          the new value of the property to be updated. A {@code null} value
   *          indicates updating the property to {@code null}.
   * @param criterion
   *          a criterion specifies the entities to be updated. A {@code null}
   *          value indicates no specified criterion, i.e., updates all entities
   *          in the underlying data storage.
   * @return the total number of entities has been updated, or zero if no entity
   *         satisfies the criterion.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public long updateProperty(String property, @Nullable Object value,
      @Nullable Criterion criterion) throws DataAccessException;

  /**
   * Updates the specified properties of the specified entities.
   *
   * @param properties
   *          a map from the property name to its value, used to set the updated
   *          properties, which cannot be {@code null}.
   * @param criterion
   *          a criterion specifies the entities to be updated. A {@code null}
   *          value indicates no specified criterion, i.e., updates all entities
   *          in the underlying data storage.
   * @return the total number of entities has been updated, or zero if no entity
   *         satisfies the criterion.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public long updateProperties(Map<String, Object> properties,
      @Nullable Criterion criterion) throws DataAccessException;

  /**
   * Adds or updates an entity in the underlying data storage.
   * <p>
   * If the entity did not exist in the underlying data storage, this function
   * will add it to the underlying data storage and assign a new identifier to
   * it if necessary; otherwise, this function will updates it in the underlying
   * data storage.
   * <p>
   * If the identifier of the entity is configured to be an automatically
   * generated field, after calling this function, the identifier property of
   * the specified entity may be set to the newly generated value.
   * <p>
   * After calling this function, this {@link Dao} object will <b>NEVER</b> keep
   * the reference to the entity passed as argument of this function. Thus
   * changing the state of the argument objects after calling this function will
   * <b>NOT</b> change the object persisted by this function.
   *
   * @param entity
   *          an entity object, which cannot be {@code null}.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public void addOrUpdate(ENTITY entity) throws DataAccessException;

  /**
   * Adds or updates a collection of entities in the underlying data storage.
   * <p>
   * If an entity in the list did not exist in the underlying data storage, this
   * function will add it to the underlying data storage and assign a new
   * identifier to it if necessary; otherwise, this function will update it in
   * the underlying data storage.
   * <p>
   * If the identifier of the entity is configured to be an automatically
   * generated field, after calling this function, the identifier property of
   * every entity in the specified collection may be set to the newly generated
   * value, and thus the collection <b>CAN NOT</b> be a hash set, since the hash
   * value of every entity in the collection will be changed.
   * <p>
   * After calling this function, this {@link Dao} object will <b>NEVER</b< keep
   * the reference to the entities passed as argument of this function. Thus
   * changing the state of the argument objects after calling this function will
   * <b>NOT</b> change the objects persisted by this function.
   *
   * @param entities
   *          a collection of entity objects, which cannot be {@code null}.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public void addOrUpdate(Collection<ENTITY> entities)
      throws DataAccessException;

  /**
   * Deletes the entity with the specified ID from the underlying data storage.
   *
   * @param id
   *          an identifier, which cannot be {@code null}.
   * @return the number of entities deleted by this operation. If there is no
   *         entity in the underlying data storage having the specified ID,
   *         nothing is done and a zero is returned.
   * @throws DataAccessException
   *           if there is no entity with the specified ID; or any data access
   *           error occurs.
   */
  public long delete(ID id) throws DataAccessException;

  /**
   * Deletes the entities with the specified collection of IDs from the
   * underlying data storage.
   *
   * @param ids
   *          a collection of identifiers, which cannot be {@code null}.
   * @return the total number of entities deleted by this operation.
   * @throws DataAccessException
   *           if there is no entity with <b>any one</b> of the specified IDs;
   *           or any data access error occurs.
   */
  public long delete(Collection<ID> ids) throws DataAccessException;

  /**
   * Deletes the entities satisfying the specified criterion from the underlying
   * storage.
   *
   * @param criterion
   *          the specified criterion, which cannot be {@code null}.
   * @return the total number of entities deleted by this operation. If there is
   *         no entities in the underlying data storage satisfying the specified
   *         criterion, nothing is done and a zero is returned.
   * @throws DataAccessException
   *           if any data access error occurs.
   */
  public long delete(Criterion criterion) throws DataAccessException;

  /**
   * Deletes all the entities from the underlying data storage.
   * <p>
   * <b>NOTE:</b> truncate and delete are totally separate SQL statements:
   * delete is DML and truncate is DDL, which means that delete can be rolled
   * back and truncate cannot be rolled back; delete has to find each row one by
   * one. truncate is instantaneous; delete use undo logs and truncate does not.
   *
   * @return the total number of entities deleted by this operation.
   * @throws DataAccessException
   *           if there is no entity with any one of the specified IDs; or any
   *           data access error occurs.
   */
  public long deleteAll() throws DataAccessException;
}
