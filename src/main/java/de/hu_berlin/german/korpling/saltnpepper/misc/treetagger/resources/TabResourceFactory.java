package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.resources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;


public class TabResourceFactory extends ResourceFactoryImpl 
{
	public Resource createResource(URI uri)
	{
		Resource resource=new TabResource();
		resource.setURI(uri);
		return(resource);
	}
}
