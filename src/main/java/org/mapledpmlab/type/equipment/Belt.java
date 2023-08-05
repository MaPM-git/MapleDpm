package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Belt extends Item {

    public Belt(JobType jobType) {
        super(200L, jobType);
        this.addMainStat(50L);
        this.addSubStat(50L);
        this.addOtherStat1(50L);
        this.addOtherStat2(50L);
        this.addAtt(6L);
        this.addMagic(6L);
        this.addHp(150L / 2);
        if (jobType == JobType.DEMON_AVENGER) {
            this.addHp((long) (250 * 4) / 2);
        } else if (jobType == JobType.XENON) {
            this.addMainStat((long) (3 * 4));
            this.addSubStat((long) (3 * 4));
            this.addOtherStat1((long) (3 * 4));
            this.addOtherStat2((long) (3 * 4));
        } else  {
            this.addMainStat((long) (5 * 4));
        }
        this.addAtt(1L);
        this.addMagic(1L);
    }
}
