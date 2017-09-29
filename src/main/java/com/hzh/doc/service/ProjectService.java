package com.hzh.doc.service;

import com.hzh.doc.data.dao.DirectoryDAO;
import com.hzh.doc.data.dao.DocumentDAO;
import com.hzh.doc.data.dao.ProjectDAO;
import com.hzh.doc.domain.Directory;
import com.hzh.doc.domain.Document;
import com.hzh.doc.domain.Project;
import com.hzh.doc.domain.TreeNode;
import com.hzh.doc.util.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private DocumentDAO documentDAO;

    @Autowired
    private DirectoryDAO directoryDAO;

    public Project addProject(Project project) {

        if (null == project.getId()) {
            project.setId(GenerateId.genUniqueKey());
        }

        Boolean result = projectDAO.addProject(project);
        if (result) {
            return project;
        }
        return null;
    }

    public List<Project> getProjects() {
        return projectDAO.findAll();
    }



    public TreeNode getMenu(String projectId) {
        List<Document> documents = documentDAO.findAllByProjectId(projectId);
        List<Directory> directories = directoryDAO.findAllByProjectId(projectId);

        Map<String, List<Document>> dirDocMap = documents.stream().collect(Collectors.groupingBy(Document::getDirId));


        Map<String, List<Directory>> dirDirMap = directories.stream().filter(d -> null != d.getDirId()).collect(Collectors.groupingBy(Directory::getDirId));

        List<Directory> dirNoNulls = new ArrayList<>(directories).stream().filter(d -> null == d.getDirId()).collect(Collectors.toList());

        TreeNode root = new TreeNode();

        root.setChildren(new ArrayList<>());

        generateData(dirNoNulls, dirDocMap, root, dirDirMap);


        return root;
    }

    public void generateData(List<Directory> directories, Map<String, List<Document>> dirDocMap, TreeNode parent, Map<String, List<Directory>> dirDirMap) {

        if (directories.size() > 0) {
           for (int i = 0; i < directories.size();i++) {

               TreeNode treeNode = new TreeNode();
               treeNode.setId(directories.get(i).getId());
               treeNode.setName(directories.get(i).getName());
               treeNode.setIsDoc(false);
               if (null == treeNode.getChildren()) {
                   treeNode.setChildren(new ArrayList<>());
               }
               parent.getChildren().add(treeNode);

               Directory directory = directories.get(i);
               if (dirDocMap.containsKey(directory.getId())) {

                   List<Document> documents = dirDocMap.get(directory.getId());

                   for(int j = 0; j < documents.size(); j++) {
                       TreeNode docTreeNode = new TreeNode();
                       docTreeNode.setId(documents.get(j).getId());
                       docTreeNode.setName(documents.get(j).getTitle());
                       docTreeNode.setIsDoc(true);
                       treeNode.getChildren().add(docTreeNode);
                   }
                   List<Directory> filterDirectories = dirDirMap.get(directory.getId());
                   if (null != filterDirectories) {
                       generateData(filterDirectories, dirDocMap,  treeNode, dirDirMap);
                   }

               }

           }
        }
    }


}
