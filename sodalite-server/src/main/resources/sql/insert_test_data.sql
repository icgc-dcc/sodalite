insert into Study (id, name,description,organization) values ('ABC123','X1-CA','A fictional study', 'Sample Data Research Institute');
insert into Study (id, name,description,organization) values ('XYZ234','X2-CA','A new study', 'Sample Data Research Institute');
insert into Donor (id, study_id, submitter_id, gender) values ('DO1','ABC123', 'Subject-X23Alpha7', 'Male');
insert into Specimen (id, donor_id, submitter_id, class, type) values ('SP1','DO1','Tissue-Culture 284 Gamma 3', 'Tumour', 'Recurrent tumour - solid tissue');
insert into Specimen (id, donor_id, submitter_id, class, type) values ('SP2','DO1','Tissue-Culture 285 Gamma 7', 'Normal', 'Normal - other');
insert into Sample (id, specimen_id, submitter_id, type) values ('SA1', 'SP1', 'T285-G7-A5','DNA'); 
insert into Sample (id, specimen_id, submitter_id, type) values ('SA11', 'SP1', 'T285-G7-B9','DNA');
insert into Sample (id, specimen_id, submitter_id, type) values ('SA21', 'SP2', 'T285-G7N','DNA');
insert into File (id, uuid, sample_id, name, size, type, metadata_doc) values ('FI1', 'uuid1', 'SA1','ABC-TC285G7-A5-ae3458712345.bam', 122333444455555, 'BAM', '<XML>Not even well-formed <XML></XML>');
insert into File (id, uuid, sample_id, name, size, type, metadata_doc) values ('FI2', 'uuid2', 'SA1','ABC-TC285G7-A5-wleazprt453.bai', 123456789, 'BAI', '<XML>Not even well-formed<XML></XML>');
insert into File(id, uuid, sample_id, name, size, type, metadata_doc) values ('FI3', 'uuid3', 'SA11', 'ABC-TC285-G7-B9-kthx12345.bai', 23456789,'BAI','<XML><Status>Inconclusive</Status></XML>');
insert into File(id, uuid, sample_id, name, size, type, metadata_doc) values ('FI4','uuid4', 'SA21','ABC-TC285-G7N-alpha12345.fai', 12345,'FAI','<XML></XML>');
insert into VariantCallAnalysis(id, study_id, state, variant_calling_tool) values ('AN1',  'ABC123', 'Suppressed', 'SuperNewVariantCallingTool');
insert into VariantCallFileSet(id, analysis_id, file_id) values ('FS1','AN1','FI1'),('FS2','AN1','FI2');
insert into SequencingReadAnalysis (id, study_id, state, library_strategy, paired_end, insert_size, aligned, alignment_tool, reference) values ('AN2','ABC123','Suppressed', 'Other', TRUE, 12345, TRUE, 'BigWrench', 'A Reference');
insert into SequencingReadFileSet(id, analysis_id, file_id) values ('FS3','AN2', 'FI1'),('FS4','AN2','FI3');
insert into MAFAnalysis(id, study_id) values ('MU1','ABC123');
insert into MAFFileSet(id, analysis_id, file_id) values ('FS3', 'MU1', 'FI1'),('FS5','MU1','FI2'),('FS6','MU1','FI3');
