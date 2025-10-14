package graphql;

import business.ModuleBusiness;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;

import java.util.List;

public class QueryModuleResolver implements GraphQLRootResolver {
    public ModuleBusiness helper;
    public QueryModuleResolver(){
        helper = new ModuleBusiness();
    }
    public List<Module> allModules()
    {
        return helper.getAllModules();

    }
    public List<Module> byTypeModule(Module.TypeModule type)
    {
        return helper.getModulesByType(type);
    }

}

