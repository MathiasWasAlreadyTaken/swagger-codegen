=begin
Swagger Petstore

This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose.

OpenAPI spec version: 1.0.0
Contact: apiteam@swagger.io
Generated by: https://github.com/swagger-api/swagger-codegen.git

License: Apache 2.0
http://www.apache.org/licenses/LICENSE-2.0.html

Terms of Service: http://swagger.io/terms/

=end

require 'spec_helper'
require 'json'

# Unit tests for Petstore::PetApi
# Automatically generated by swagger-codegen (github.com/swagger-api/swagger-codegen)
# Please update as you see appropriate
describe 'PetApi' do
  before do
    # run before each test
    @instance = Petstore::PetApi.new
  end

  after do
    # run after each test
  end

  describe 'test an instance of PetApi' do
    it 'should create an instact of PetApi' do
      expect(@instance).to be_instance_of(Petstore::PetApi)
    end
  end

  # unit tests for add_pet
  # Add a new pet to the store
  # 
  # @param body Pet object that needs to be added to the store
  # @param [Hash] opts the optional parameters
  # @return [nil]
  describe 'add_pet test' do
    it "should work" do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for delete_pet
  # Deletes a pet
  # 
  # @param pet_id Pet id to delete
  # @param [Hash] opts the optional parameters
  # @option opts [String] :api_key 
  # @return [nil]
  describe 'delete_pet test' do
    it "should work" do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for find_pets_by_status
  # Finds Pets by status
  # Multiple status values can be provided with comma separated strings
  # @param status Status values that need to be considered for filter
  # @param [Hash] opts the optional parameters
  # @return [Array<Pet>]
  describe 'find_pets_by_status test' do
    it "should work" do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for find_pets_by_tags
  # Finds Pets by tags
  # Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
  # @param tags Tags to filter by
  # @param [Hash] opts the optional parameters
  # @return [Array<Pet>]
  describe 'find_pets_by_tags test' do
    it "should work" do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for get_pet_by_id
  # Find pet by ID
  # Returns a single pet
  # @param pet_id ID of pet to return
  # @param [Hash] opts the optional parameters
  # @return [Pet]
  describe 'get_pet_by_id test' do
    it "should work" do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for update_pet
  # Update an existing pet
  # 
  # @param body Pet object that needs to be added to the store
  # @param [Hash] opts the optional parameters
  # @return [nil]
  describe 'update_pet test' do
    it "should work" do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for update_pet_with_form
  # Updates a pet in the store with form data
  # 
  # @param pet_id ID of pet that needs to be updated
  # @param [Hash] opts the optional parameters
  # @option opts [String] :name Updated name of the pet
  # @option opts [String] :status Updated status of the pet
  # @return [nil]
  describe 'update_pet_with_form test' do
    it "should work" do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for upload_file
  # uploads an image
  # 
  # @param pet_id ID of pet to update
  # @param [Hash] opts the optional parameters
  # @option opts [String] :additional_metadata Additional data to pass to server
  # @option opts [File] :file file to upload
  # @return [ApiResponse]
  describe 'upload_file test' do
    it "should work" do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

end
