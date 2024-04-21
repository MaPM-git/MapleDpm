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
            this.addMainStatP(-35L);
            if (this.getLevel() == 250L) {
                this.addMainStatP(-3L);
            }
        } else if (jobType == JobType.XENON) {
            this.addAllStatP(-24L);
            if (this.getLevel() == 250) {
                this.addAllStatP(-3L);
            }
        } else  {
            this.addMainStatP(-32L);
            if (this.getLevel() == 250) {
                this.addMainStatP(-3L);
            }
        }
        this.addAtt(1L);
        this.addMagic(1L);
    }
}
