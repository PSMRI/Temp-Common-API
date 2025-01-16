package com.iemr.common.service.grievance;

import java.util.List;
import java.util.Map;

public interface GrievanceDataSync {
	public List<Map<String, Object>> dataSyncToGrievance(String grievanceAuthorization, String registeringUser,
            String Authorization);
}
