package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Item extends Common {
    private JobType jobType;

    public Item(Long level, JobType jobType) {
        this.setLevel(level);
        this.jobType = jobType;
        this.addStarforce();
        this.addOption();
        this.addPotential();
        this.addAdditionalPotential();
    }
    
    public Item(JobType jobType, Long level) {        // 추가옵션 없는 아이템 전용
        this.setLevel(level);
        this.jobType = jobType;
        this.addStarforce();
        this.addPotential();
        this.addAdditionalPotential();
    }
    
    public Item(Long level) {    // 잠재/스타포스 없는 아이템 전용
        this.setLevel(level);
        this.addOption();
    }
    
    public Item() {}              // 잠재/스타포스/추가옵션 없는 아이템 전용

    public void addStarforce() {
        this.addMainStat((long) (2 * 5 + 3 * 10));  // 1~15성 공통
        this.addSubStat((long) (2 * 5 + 3 * 10));
        this.addHp(255L);
        if (this.jobType == JobType.XENON) {
            this.addOtherStat1((long) (2 * 5 + 3 * 10));  // 1~15성 공통
            this.addOtherStat2((long) (2 * 5 + 3 * 10));
        }
        if (this.getLevel() == 130) {
            this.addMainStat((long) (7 * 5));
            this.addSubStat((long) (7 * 5));
            this.addAtt((long) (7 + 8 + 9 + 10 + 11));
            this.addMagic((long) (7 + 8 + 9 + 10 + 11));
            if (this.jobType == JobType.XENON) {
                this.addOtherStat1((long) (7 + 8 + 9 + 10 + 11));
                this.addOtherStat2((long) (7 + 8 + 9 + 10 + 11));
            }
        } else if (this.getLevel() == 140) {
            this.addMainStat((long) (9 * 7));
            this.addSubStat((long) (9 * 7));
            this.addAtt((long) (8 + 9 + 10 + 11 + 12 + 13 + 15));
            this.addMagic((long) (8 + 9 + 10 + 11 + 12 + 13 + 15));
            if (this.jobType == JobType.XENON) {
                this.addOtherStat1((long) (8 + 9 + 10 + 11 + 12 + 13 + 15));
                this.addOtherStat2((long) (8 + 9 + 10 + 11 + 12 + 13 + 15));
            }
        } else if (this.getLevel() == 150) {
            this.addMainStat((long) (11 * 7));
            this.addSubStat((long) (11 * 7));
            this.addAtt((long) (9 + 10 + 11 + 12 + 13 + 14 + 16));
            this.addMagic((long) (9 + 10 + 11 + 12 + 13 + 14 + 16));
            if (this.jobType == JobType.XENON) {
                this.addOtherStat1((long) (9 + 10 + 11 + 12 + 13 + 14 + 16));
                this.addOtherStat2((long) (9 + 10 + 11 + 12 + 13 + 14 + 16));
            }
        } else if (this.getLevel() == 160) {
            this.addMainStat((long) (13 * 7));
            this.addSubStat((long) (13 * 7));
            this.addAtt((long) (10 + 11 + 12 + 13 + 14 + 15 + 17));
            this.addMagic((long) (10 + 11 + 12 + 13 + 14 + 15 + 17));
            if (this.jobType == JobType.XENON) {
                this.addOtherStat1((long) (10 + 11 + 12 + 13 + 14 + 15 + 17));
                this.addOtherStat2((long) (10 + 11 + 12 + 13 + 14 + 15 + 17));
            }
        } else if (this.getLevel() == 200) {
            this.addMainStat((long) (15 * 7));
            this.addSubStat((long) (15 * 7));
            this.addAtt((long) (12 + 13 + 14 + 15 + 16 + 17 + 19));
            this.addMagic((long) (12 + 13 + 14 + 15 + 16 + 17 + 19));
            if (this.jobType == JobType.XENON) {
                this.addOtherStat1((long) (12 + 13 + 14 + 15 + 16 + 17 + 19));
                this.addOtherStat2((long) (12 + 13 + 14 + 15 + 16 + 17 + 19));
            }
        } else if (this.getLevel() == 250) {
            this.addMainStat((long) (17 * 7));
            this.addSubStat((long) (17 * 7));
            this.addAtt((long) (14 + 15 + 16 + 17 + 19 + 19 + 21));
            this.addMagic((long) (14 + 15 + 16 + 17 + 19 + 19 + 21));
            if (this.jobType == JobType.XENON) {
                this.addOtherStat1((long) (14 + 15 + 16 + 17 + 19 + 19 + 21));
                this.addOtherStat2((long) (14 + 15 + 16 + 17 + 19 + 19 + 21));
            }
        }
    }

    private void addOption() {  // 1추 단일, 1추 올스탯
        if (this.getLevel() == 250) {
            this.addHp((long) (19.6 * this.getLevel()));
        }
        this.addHp(21 * this.getLevel());
        this.addAllStatP(7L);
        if (this.jobType == JobType.XENON) {
            if (this.getLevel() <= 150) {
                this.addMainStat(28L);
                this.addSubStat(28L);
                this.addOtherStat1(28L);
            } else if (this.getLevel() == 160) {
                this.addMainStat(35L);
                this.addSubStat(35L);
                this.addOtherStat1(35L);
            } else if (this.getLevel() == 200) {
                this.addMainStat(42L);
                this.addSubStat(42L);
                this.addOtherStat1(42L);
            } else if (this.getLevel() == 250) {
                this.addMainStat(49L);
                this.addSubStat(49L);
                this.addOtherStat1(49L);
            }
            return;
        }
        if (this.getLevel() == 130) {
            this.addMainStat(49L);
        } else if (this.getLevel() == 140) {
            this.addMainStat(56L);
        } else if (this.getLevel() == 150) {
            this.addMainStat(56L);
        } else if (this.getLevel() == 160) {
            this.addMainStat(63L);
        } else if (this.getLevel() == 200) {
            this.addMainStat(77L);
        } else if (this.getLevel() == 250) {
            this.addMainStat(84L);
        }
    }

    private void addPotential() {   // 이탈X 3줄
        if (this.jobType == JobType.XENON) {
            this.addAllStatP(21L);
            if (this.getLevel() == 250) {
                this.addAllStatP(3L);
            }
        } else {
            this.addMainStatP(30L);
            if (this.getLevel() == 250) {
                this.addMainStatP(3L);
            }
        }
    }

    private void addAdditionalPotential() {     // 이탈X 2줄
        if (this.jobType == JobType.XENON) {
            this.addAllStatP(11L);
            if (this.getLevel() == 250) {
                this.addAllStatP(2L);
            }
        } else if (this.jobType == JobType.DEMON_AVENGER) {
            this.addMainStatP(19L);
            if (this.getLevel() == 250) {
                this.addMainStatP(2L);
            }
        } else {
            this.addMainStatP(14L);
            if (this.getLevel() == 250) {
                this.addMainStatP(2L);
            }
        }
    }
}
