package org.mapledpmlab.type.hyper;

public class HyperDemonAvenger extends Hyper {
    private final Long[] reqPoint = {0L, 1L, 3L, 7L, 15L, 25L, 40L, 60L,
            85L, 115L, 150L, 200L, 265L, 345L, 440L, 550L};

    public HyperDemonAvenger(Long level, Double criticalP) {
        Long point = 0L;
        if (level < 280) {
            point = 1186 + 16 * (level % 10);
        } else if (level < 290) {
            point = 1347 + 17 * (level % 10);
        } else if (level < 300) {
            point = 1518 + 18 * (level % 10);
        }

        if (criticalP <= 70) {
        } else if (criticalP < 100) {
            Long reqCriticalP = (long) (100 - criticalP);
            if (reqCriticalP <= 5) {
                point -= reqPoint[Math.toIntExact(reqCriticalP)];
                this.addCriticalP(Double.valueOf(reqCriticalP));
            } else {
                Long reqLevel = 5L;
                point -= reqPoint[(int) (reqLevel + Math.ceil((reqCriticalP - 5) / 2.0))];
                this.addCriticalP(5.0 + Math.ceil((reqCriticalP - 5) / 2.0) * 2);
            }
        }

        this.addBossDamage(51L);
        point -= 440L;
        this.addCriticalDamage(12.0);
        point -= 265L;
        this.addDamage(42L);
        point -= 440L;

        for (int i = 15; i > 0; i--) {
            if (point >= reqPoint[i]) {
                point -= reqPoint[i];
                this.addIgnoreDefenseList((long) (3L * i));
                break;
            }
        }

        for (int i = 15; i > 0; i--) {
            if (point >= reqPoint[i]) {
                point -= reqPoint[i];
                this.addAtt((long) (3L * i));
                this.addMagic((long) (3L * i));
                break;
            }
        }

        for (int i = 15; i > 0; i--) {
            if (point >= reqPoint[i]) {
                point -= reqPoint[i];
                this.addMainStatP((long) (2L * i));
                break;
            }
        }

        for (int i = 15; i > 0; i--) {
            if (point >= reqPoint[i]) {
                point -= reqPoint[i];
                this.addPerXSubStat((long) (30L * i));
                break;
            }
        }

        this.setDescription("\n하이퍼 스탯" +
                "\n1.크리티컬 확률 : " + this.getCriticalP() +"%" +
                "\n2.보스 공격 시 데미지 : " + this.getBossDamage() + "%" +
                "\n3.크리티컬 데미지 : " + this.getCriticalDamage() + "%" +
                "\n4.데미지 : " + this.getDamage() + "%" +
                "\n5.몬스터 방어율 무시 : " + this.getIgnoreDefense() + "%" +
                "\n6.공격력/마력 : " + this.getAtt() +
                "\n7.HP(%) : " + this.getMainStatP() +
                "\n8.부스탯(%미적용) : " + this.getPerXSubStat()
        );
    }
}
