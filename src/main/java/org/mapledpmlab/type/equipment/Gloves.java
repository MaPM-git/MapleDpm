package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Gloves extends Item {

    public Gloves(JobType jobType) {
        super(200L, jobType);
        this.addMainStat(40L);
        this.addSubStat(40L);
        this.addAtt(9L);
        this.addCriticalDamage(11.0);
        this.addAtt((long) (4 * 8));
        if (jobType == JobType.DEMON_AVENGER) {
            this.addMainStatP(-23L);
            if (this.getLevel() == 250L) {
                this.addMainStatP(-2L);
            }
        } else if (jobType == JobType.XENON) {
            this.addAllStatP(-15L);
            if (this.getLevel() == 250) {
                this.addAllStatP(-2L);
            }
        } else  {
            this.addMainStatP(-20L);
            if (this.getLevel() == 250) {
                this.addMainStatP(-2L);
            }
        }
        this.addAtt(1L);
        this.addMagic(1L);
    }
}
